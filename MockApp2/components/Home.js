import React, {useEffect, useState} from 'react';
import {View, Text , StyleSheet, Image, FlatList, ActivityIndicator, Pressable, TouchableOpacity, Button, TouchableOpacityBase,ScrollView,KeyboardAvoidingView,TextInput} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import colors from '../assets/colors/colors';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';
import TaskList from './TaskList';


export default function Home () {

    const testUserId = 1
    
    const [tasks, setTasks] = useState([]);
    const [tasksLoaded, setTasksLoaded] = useState(false);
    const [userData, setUserData] = useState({})
    const [userLoading, setuserLoading] = useState(true)



    const loadTaskData = function(userId){
    fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks')
    .then((response) => response.json())
    .then((json) => setTasks(json))
    .catch((error) => alert(error))
    .finally(setTasksLoaded(true))
    }

    const loadUserData = function(userId){
        fetch('http://10.0.2.2:8080/users/' + userId.toString() + '/')
        .then((response) => response.json())
        .then((json)=> setUserData(json))
        .catch((error) => alert(error))
        .finally(setuserLoading(false))
    }

    const deleteTask = function(userId, taskId){
        fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks/' + taskId.toString()+ '/', {
            method: 'DELETE'})
        .then((response) => response.json())
        .then((json) => setTasks(json))
    }

    const payload = {"name": "Go For A Walk",
                    "description": "very hard task mate ello mate",
                    "status": false
                }

    const addTask = function(userId, payload){
        
        fetch('http://10.0.2.2:8080/users/' + userId.toString() + '/tasks', {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(payload)})
            .then((response) => response.json())
            .then((json) => setTasks(json))
    }

    const markComplete = function(userId, taskId){
        
        const filter = function(jsonObject){
            const newUserData = {
                "username": jsonObject.username,
                "level": jsonObject.level,
                "currentXp": jsonObject.currentXp,
                "maximumXp": jsonObject.maximumXp,
                "health": jsonObject.health
            }

            setUserData(newUserData)
            setTasks(jsonObject.tasks)

            console.log(userData)
            console.log(tasks)
        }

        fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks/' + taskId.toString() + '/markcomplete', {
            method: 'PATCH'
        }).then((response) => response.json())
        .then((json) => filter(json))
        .catch((error) => alert(error)) 
    };
    
    useEffect(() => {
        loadTaskData(testUserId)
        loadUserData(testUserId)
    }, []);

    
    return(
        <View>
        {userLoading === false && tasks.length !== 0 ? 
            <View>
                <TaskList tasks={tasks} onPressFunction={markComplete}/>
            </View>
            :
            <Text>Loading...</Text>
        }
        </View>
    );
    
};

const styles = StyleSheet.create({

    // HEADER
    container:{
        flex:1,
       
    },
    headerWrapper:{
        flexDirection:'row',
        justifyContent:'space-between',
        paddingHorizontal:0,
        paddingTop:0,
        alignItems:'center',
    },
    profileImage:{
        width:116,
        height:167,
        borderRadius:3,
    },


    // TODAY TASK'S
    taskItem:{
        margin: 5,
        flex: 1,
        padding: 20,
        backgroundColor:colors.backgroundLight,
    },
    tasksWrapper:{
        paddingTop: 80,
        paddingHorizontal: 20,
    },
    sectionTitle:{
        fontFamily:'Raleway-Bold',
        fontSize: 24,
       
    },
    items:{
        marginTop:30,
    },
  
    //Task's Styling
    writeTaskWrapper:{
        position:'absolute',
        bottom: 60,
        width:'100%',
        flexDirection:'row',
        justifyContent:'space-around',
        alignItems:'center'
      
      
      
      },
      
      input:{
      paddingVertical:15,
      paddingHorizontal:15,
      backgroundColor:colors.primary,
      borderRadius:60,
      borderColor:'#C0C0C0',
      borderWidth:1,
      width:250,
      },
      
      addWrapper:{
        width:12,
        height:12,
        backgroundColor:colors.background,
        borderRadius:12,
        justifyContent:'space-around',
        alignItems:'center',
        borderColor:colors.secondary,
        borderWidth:1,  
      
      
      },
      addText:{},
 
      

    main:{
        backgroundColor: colors.background,
    },
    
  
    infoText:{
        fontSize: 30
    },

     // Mark Completed Styling
     markCompeteText:{
         fontFamily:'Raleyway-Bold',
         fontSize:12,
     },
    
     addText:{
         textAlign:'justify'
     },
     popularTopWrapper:{
        flexDirection:'row',
        alignItems:'center',
    },


    // DELETE!!!
    deleteTaskWrapper:{
        
    },
    buttonContainer:{},
    deleteText:{},

    //ADD TASK
    addTaskWrapper:{
        width:60,
        height:60,
        backgroundColor:'#FFF',
        borderRadius:60,
        justifyContent:'center',
        alignItems:'center',
        borderColor:'#C0C0C0',
        borderWidth:1, 
    },
    AddTaskText:{},

    // USERNAME
    userNameText:{
        fontSize:16,
        fontFamily:'Raleway-ExtraBold',
        flexDirection:'column',
        flex:1,
        justifyContent:'flex-start',
        alignSelf:'flex-end',
        position:'absolute',
        bottom:35,
        
       
 

    },




    },
)
