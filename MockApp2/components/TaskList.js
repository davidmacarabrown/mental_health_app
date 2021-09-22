import React from 'react';
import {View, FlatList, Text} from 'react-native';
import TaskItem from './TaskItem';

const TaskList =  (props) => {

    const renderItem = ({item}) => {
        console.log("THIS IS THE ITEM", item, "££££££££££")
        return(
            <View>
            <TaskItem 
                item={item}
                onPress={()=> props.onPressFunction(1, item.id)}
                />
            </View>
        )
    }
    console.log("++++++", props.tasks, "+++++++")
    console.log("%%%%%", props.tasks[0].description, "%%%%%%")
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