__author__ = 'akankshanagpal'

#!/usr/bin/env python

from cqlengine import columns
from cqlengine.models import Model

# Model Definition
class Rsvpstream(Model):
    venue_name = columns.Text()
    venue_lon = columns.Decimal(required=False)
    venue_lat = columns.Decimal(required=False)
    venue_id = columns.Integer()
    visibility = columns.Text()
    response = columns.Text()
    guests = columns.Integer()
    member_id = columns.Integer()
    member_name = columns.Text()
    rsvp_id = columns.Integer(primary_key=True)
    rsvp_last_modified_time = columns.DateTime(required=False)
    event_name = columns.Text()
    event_time = columns.DateTime(required=False)
    event_url = columns.Text()
    group_topic_names = columns.Text()
    group_country = columns.Text()
    group_state = columns.Text()
    group_city = columns.Text()
    group_name = columns.Text()
    group_lon = columns.Integer()
    group_lat = columns.Integer()
    group_id = columns.Integer()
