import React from 'react';
import {View, FlatList, Text} from 'react-native';
import TaskItem from './TaskItem';

const TaskList =  (props) => {

    const renderItem = ({item}) => {

        return(
            <View>
            <TaskItem 
                item={item}
                markComplete={()=> props.onPressFunction(1, item.id)}
                deleteTask={()=> props.onPressFunctionTwo(1, item.id)}
                />
            </View>
        )
    }

    return(
        <View>
                 <FlatList 
                     data={props.tasks}
                     renderItem={renderItem}
                     keyExtractor={(item) => item.id}
                 />

        </View>
    )
}

export default TaskList;