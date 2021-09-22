import React from 'react';
import {View, Text, TouchableOpacity} from 'react-native';
import Feather from 'react-native-vector-icons/Feather';
import colors from '../assets/colors/colors';

const TaskItem = (props) => {

    console.log("TASK ITEM PROPS:", props,)
    return(
        <View>

        {/* Today's Tasks  */}
  <View>
    <Text>{props.item.name}</Text>

        <TouchableOpacity onPress={props.markComplete}>
            <Text>{props.item.description}</Text>
            <View>
            {!props.item.status ? <Feather
                    name="check"
                     size={30 }
                    color={colors.primary}
                /> :
                <Text>complete!</Text>
                }
            
            </View>
        </TouchableOpacity>
        <TouchableOpacity onPress={props.deleteTask}>
                <Feather name="x-circle"
                        size={30 }
                        color={"#b53833"}/>
        </TouchableOpacity>
    </View>
    </View>
    )
}

export default TaskItem;
