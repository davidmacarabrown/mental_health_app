import React from 'react';
import {Text, TouchableOpacity} from 'react-native';

export default function TaskItem ({item, onPress}) {
    return(
    <TouchableOpacity onPress={onPress}>
        <Text>{item.name}</Text>
        <Text>{item.description}</Text>
        <Text>-----------------------</Text>
    </TouchableOpacity>
    )
}