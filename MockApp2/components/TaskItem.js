import React from 'react';
import {Text, TouchableOpacity} from 'react-native';
import Feather from 'react-native-vector-icons/Feather';
import colors from '../assets/colors/colors';

export default function TaskItem ({item, onPress}) {
    return(
        <View style={styles.taskItem}>

        {/* Today's Tasks  */}
  <View style={styles.tasksWrapper}>
    <Text style={styles.sectionTitle}>{item.name}</Text>

    <View style={styles.items}></View>

        <TouchableOpacity onPress={onPress}>
            <Text style={styles.title}>{item.name}</Text>
            <View style={styles.markCompletedIcon}>
            <Feather
                    name="check"
                     size={30 }
                    color={colors.primary}
                />
            </View>
        </TouchableOpacity>
        <TouchableOpacity>
        
        </TouchableOpacity>
    </View>
    </View>
    )
}
