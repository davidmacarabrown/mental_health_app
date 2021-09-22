import React from 'react';
import {View, Text, TouchableOpacity} from 'react-native';
import Feather from 'react-native-vector-icons/Feather';
import colors from '../assets/colors/colors';

export default function TaskItem ({item, onPress}) {
    return(
        <View>

        {/* Today's Tasks  */}
  <View>
    <Text>{item.name}</Text>

        <TouchableOpacity onPress={onPress}>
            <Text>{item.description}</Text>
            <View>
            {!item.status ? <Feather
                    name="check"
                     size={30 }
                    color={colors.primary}
                /> :
                <Text>complete!</Text>
                }
            
            </View>
        </TouchableOpacity>
        <TouchableOpacity>
        
        </TouchableOpacity>
    </View>
    </View>
    )
}
