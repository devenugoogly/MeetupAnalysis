__author__ = 'akankshanagpal'

import json
import datetime
import codecs

def get_dict_val(dict, key_name):
    """
    Receives the arguments = dict, key_name
    Returns the value
    """
    return dict.get(key_name)

def load_json(msg):
    """
    Load the message value to json.
     """
    dic = json.loads(msg.decode('utf-8'))
    print(dic)
    return  dic


def datetime_from_epoch(time):
    return datetime.datetime.utcfromtimestamp(float(time)/1000.0)
