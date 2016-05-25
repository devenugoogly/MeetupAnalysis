#!/usr/bin/env python

# Kafka Library
from kafka import SimpleProducer, KafkaClient

# https://github.com/liris/websocket-client
from websocket import create_connection

# Kafka Producer
kafka = KafkaClient("localhost:9092")
producer = SimpleProducer(kafka)

def rsvp_source():
    """
    1. Connects to meetup rsvp websocket stream.
    2. Received the stream.
    3. Sends the stream as a producer.
    """
    ws = create_connection('ws://stream.meetup.com/2/rsvps')
    while True:
        try:
            rsvp_data = ws.recv() # Get realtime data using web socketss
            bytes = str.encode(rsvp_data)
            print(rsvp_data)
            if rsvp_data:
                # Send the stream to the topic "rsvp_stream"
                producer.send_messages("rsvp_stream", bytes)
        # No matter what the Exception is keep calling the function recursively
        except Exception():
            rsvp_source()


if __name__ == '__main__':
    rsvp_source()
