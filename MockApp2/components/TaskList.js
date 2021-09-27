import React from 'react';
import {StyleSheet, View, FlatList, Text} from 'react-native';
import colors from '../assets/colors/colors';
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
        <View style={Styles.tasksWrapper}>
                 <FlatList 
                     data={props.tasks}
                     renderItem={renderItem}
                     keyExtractor={(item) => item.id}
                 />

        </View>
    )
}

const Styles = StyleSheet.create({

    tasksWrapper:{
        paddingTop: 80,
        paddingHorizontal: 20,
        borderRadius:10,
        color:colors.primary,
        
    },
    sectionTitle:{
        fontFamily:'Raleway-Bold',
        fontSize: 24,
       
    },
    items:{
        marginTop:30,
    },
})

export default TaskList;