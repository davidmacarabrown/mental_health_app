import React, {useEffect, useState} from 'react';
import {View, Text , StyleSheet, Image, FlatList, ActivityIndicator, Pressable, TouchableOpacity, Button} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import colors from '../assets/colors/colors';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';


export default function Home () {

    const testUserId = 1
    
    const [tasks, setTasks] = useState([]);
    const [tasksLoaded, setTasksLoaded] = useState(false);
    const [userData, setUserData] = useState({})
    const [userLoaded, setUserLoaded] = useState(false)

    const loadTaskData = function(userId){
        fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks')
        .then((response) => response.json())
        .then((json) => setTasks(json))
        .catch(() => alert("Tasks Unavailable"))
        .finally(setTasksLoaded(true))
    }

    const loadUserData = function(userId){
        fetch('http://10.0.2.2:8080/users/' + userId.toString() + '/')
        .then((response) => response.json())
        .then((json)=> setUserData(json))
        .catch(() => alert("User Not Found"))
        .finally(setUserLoaded(true))
    }

    const deleteTask = function(userId, taskId){
        fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks/' + taskId.toString()+ '/', {
            method: 'DELETE'})
        .then((response) => {if (response.status === "202"){
            tasks.forEach((task, index, array) => {
                if (task.id === taskId){
                    array.splice(index, 1)
                }
            })
        }}) 
    }

    const payload = {"name": "some random name",
                    "description": "very hard task mate ello mate",
                    "status": false}

    const addTask = function(userId, payload){
        
        fetch('http://10.0.2.2:8080/users/' + userId.toString() + '/tasks', {
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
        .then((json) => setUserData(json))
    }
    
    useEffect(() => {
        loadTaskData(testUserId)
        loadUserData(testUserId)
    }, []);

    const TaskItem = ({item, onPress}) => (
        <TouchableOpacity onPress={onPress}>
            <Text>{item.name}</Text>
        </TouchableOpacity>
    
    )

    const renderItem = ({item}) => {
        const taskId = item.id;
        return(
            <TaskItem 
                item={item}
                onPress={()=> markComplete(testUserId, taskId)}
                />
        )
    }

    return(
        <View>
        {userLoaded === false || tasks.length === 0 ?  <Text>LOADING...</Text> : 

            <View>
                <TouchableOpacity onPress={()=> deleteTask(testUserId, 1)}>
                    <Text>DELETE THE TASK</Text>
                </TouchableOpacity>

                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

                <TouchableOpacity onPress={()=> markComplete(testUserId, 1)}>
                    <Text>MARK COMPLETE</Text>
                </TouchableOpacity>

                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

                <TouchableOpacity onPress={()=> addTask(testUserId, payload)}>
                    <Text>ADD TASK</Text>
                </TouchableOpacity>

                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>{tasks.length.toString()}</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

                <FlatList 
                    data={tasks}
                    renderItem={renderItem}
                    keyExtractor={(item) => item.id}
                />
            </View>
        
        }   
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>
                <Text>-----------------------</Text>

        {userLoaded ? <View>
                            <Text>{userData.username}</Text>
                            <Text>{userData.currentXp}</Text>
                            <Text>{userData.level}</Text>
                            <Text>{userData.health}</Text>
                        </View>
                        :
                        <View>
                            <Text>NO USER LOADED</Text>
                        </View> 
                        }
                        
        </View>
    );
    
};



