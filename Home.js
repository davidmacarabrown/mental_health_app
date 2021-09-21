import React, {useEffect, useState} from 'react';
import {View, Text , StyleSheet, Image, FlatList, ActivityIndicator, Pressable, TouchableOpacity, Button} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import colors from '../assets/colors/colors';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';
import TaskItem from './TaskItem';

export default function Home () {

    const [isLoading, setLoading] = useState(true);
    const [tasks, setTasks] = useState([])


    const loadTaskData = function(){
        fetch('http://10.0.2.2:8080/users/1/tasks')
        .then((response) => response.json())
        .then((json) => setTasks(json))
        .catch(() => alert("Tasks Unavailable"))
        .finally(setLoading(false))
    }

    const deleteTask = function(user, task){
       const userId = user.toString()
       const taskId = task.toString()
        fetch('http://10.0.2.2:8080/users/'+userId+'/tasks/' +taskId, {
            method: 'DELETE'}) 
    }

    const payload = {"name": "some random name",
                    "description": "very hard task mate ello mate",
                    "status": false}

    const addTask = function(userId, payload){
        
        fetch('http://10.0.2.2:8080/users/' + userId + '/tasks', {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(payload)})
            .then((response) => response.json())
            .then((json) => tasks.push(json))
    }

    const markComplete = function(userId, taskId){
        
        fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks/' + taskId.toString() + '/markcomplete', {
            method: 'PATCH'
        }).then((response) => response.json())
        .then((response) => taskUpdateHandler(response, taskId))
    }
    
    useEffect(() => {
        loadTaskData()
    }, []);

    //put checking for array length into the conditional statement
    return(
        <View>
        {tasks.length === 0 ?  <Text>LOADING...</Text> : 

            <View>
                <TaskItem props={tasks[0]}></TaskItem>

                <TouchableOpacity onPress={()=> deleteTask(1, 1)}>
                    <Text>DELETE THE TASK</Text>
                </TouchableOpacity>

                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

                <TouchableOpacity onPress={()=> markComplete(1, 1)}>
                    <Text>MARK COMPLETE</Text>
                </TouchableOpacity>

                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

                <TouchableOpacity onPress={()=> addTask(1, payload)}>
                    <Text>ADD TASK</Text>
                </TouchableOpacity>
                
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

                <Text>{tasks.length.toString()}</Text>
            </View>
        
        }   
        </View>
    );
    
};


