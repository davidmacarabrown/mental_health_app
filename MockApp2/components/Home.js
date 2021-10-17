import React, {useEffect, useState} from 'react';
import { View, Text , StyleSheet, Image, FlatList, ActivityIndicator, Pressable, TouchableOpacity, Button, TouchableOpacityBase,ScrollView,KeyboardAvoidingView,TextInput, ImageBackground, Dimensions} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import Entypo from 'react-native-vector-icons/Entypo'
import colors from '../assets/colors/colors';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';
import StartPage from './StartPage';
import TaskList from './TaskList';

const height = Dimensions.get("window").height;


export default function Home () {

    const testUserId = 1
    
    const [tasks, setTasks] = useState([]);
    const [userData, setUserData] = useState({})
    const [userLoading, setuserLoading] = useState(true)

    const [newTaskName, setNewTaskName] = useState(null)
    const [newTaskDescription, setNewTaskDescription] = useState(null)

    const [displayState, setDisplayState] = useState(0)

    const loadTaskData = function(userId){
    fetch('http://10.0.2.2:8080/users/'+ userId.toString() +'/tasks')
    .then((response) => response.json())
    .then((json) => setTasks(json))
    .catch((error) => alert(error))
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
        .catcn((error) => alert(error))
    }

    const addTask = function(userId){

        console.log(newTaskName, newTaskDescription)

        const payload = {
            "name": newTaskName,
            "description": newTaskDescription
        }

        if (newTaskName && newTaskDescription){

            fetch('http://10.0.2.2:8080/users/' + userId.toString() + '/tasks', {

                method: 'POST',
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(payload)
            })
                .then((response) => response.json())
                .then((json) => setTasks(json))

                setDisplayState(1)  
                setNewTaskDescription(null)
                setNewTaskName(null)

            } else {
                alert("Please complete all fields.")
            }
    }

    const markComplete = function(userId, taskId){

        const filter = (data) => {
            setUserData(data.user)
            setTasks(data.tasks)
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

    const enterApp= () => {
        console.log("entering the app")
        setDisplayState(1)
    }
    
    return(
        <ScrollView>
           
            {displayState === 0 ? 
            <View>
                <StartPage enterApp={enterApp}/>
            </View>: 
            null}
             <View style={styles.container}>
                <ImageBackground 
                    source={require('../assets/images/AvatarGirl1.jpeg')} 
                    style={styles.backgroundImage}>
                    <TouchableOpacity style={styles.activityWrapper} >  
                    <Feather name='activity' size={32} color={colors.white} style={styles.activityIcon}/>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.HealthWrapper}>
                    {/* <Feather name='align-center' size={32} color={colors.white} style={styles.menuIcon}/> */}
                    </TouchableOpacity>
                    
                
                    
                    <View style={styles.profileWrapper}>
                        <Text style={styles.textLevel}>{userData.level}</Text>
                        <Text style={styles.textLevelBox}>Level</Text>
                        </View>
                        <View style={styles.profileWrapper2}>
                        <Text style={styles.textHealth}>{userData.health}</Text>
                        <Text style={styles.textHealthBox}>Health</Text>
                        </View>
                   
                    </ImageBackground>


                <View style={styles.tasksWrapper}>
                </View>
                
            </View>

            
            <View> 
            {/* TASK LIST CONTAINER */}
            {/* IF tasks and user are loaded show the task list, else show "no tasks available" */}
            {displayState === 1 && userLoading === false && tasks.length !== 0 ? 
                <View >
                    <TaskList tasks={tasks} onPressFunction={markComplete} onPressFunctionTwo={deleteTask}/>
                </View>
                : null
            
            }{displayState === 1 ?
            <TouchableOpacity style={styles.buttonWrapper}>
                {tasks.length === 0 ? 
                    <Text style={styles.noTaskText}>No Tasks Available...</Text> : null}
                <Text style={styles.buttonText} onPress={() => setDisplayState(2)} >Add Task</Text>
                </TouchableOpacity>
            : null}

            
            </View>
            

        {displayState === 2 && userLoading === false ? 
        <TouchableOpacity style={styles.addTasksWrapper}>
        <View>
            <View style={styles.TaskNameText}>
            <TextInput placeholder={"Task name"} style={styles.textBox} onChangeText={(value) => setNewTaskName(value)}/>
            </View>
            <TextInput placeholder={"Task description"} style={styles.textBox} onChangeText={(value) => setNewTaskDescription(value)}/>
            <Text style={styles.addTaskTextSave} onPress={()=> addTask(testUserId)}>Save Task</Text> 
            
            <Text style={styles.backButton} onPress={()=> setDisplayState(1)}>Back</Text>
        </View>
        </TouchableOpacity>
        :
        <View></View>}
             
        </ScrollView>
    );
    
};

const styles = StyleSheet.create({

    // HEADER
    container:{
        flex:1,
        backgroundColor:colors.white,
       
    },

    backgroundImage:{
        height:height * 0.6,
        justifyContent:'space-between',
    },
    tasksWrapper:{
        flex:1,
        backgroundColor:colors.white,
        marginTop:-20,
        borderRadius:25,
    },

    activityIcon:{
        position:'absolute',
        marginLeft:10,
        marginTop:60,
    },
    // menuIcon:{
    //    position:'space-between',
    //    position:'absolute',
    //    right:0,
    //    margin:10,
    //    marginTop:10,
    //    marginBottom:30,
    
    // },
        activityWrapper:{
        },
        HealthWrapper:{
        },

       
        
    profileWrapper:{
        marginHorizontal:20,
        marginBottom:10,
       
    },
    profileWrapper2:{
        position:'absolute',
        right:0,
        margin:10,
        marginHorizontal:20,
        marginBottom:10,
        bottom:0,
    },

    textLevel:{
        fontFamily:'Raleway-Bold',
        fontSize:32,
        color:colors.white,
    },
    textLevelBox:{
        fontFamily:'Raleway-Bold',
        fontSize:18,
        color:colors.textLight,
    },
    textHealth:{
        fontFamily:'Raleway-Bold',
        fontSize:32,
        color:colors.white,

    },
    textHealthBox:{
        fontFamily:'Raleway-Bold',
        fontSize:18,
        color:colors.textLight,
        justifyContent:'space-between',
    },

    // Button
    buttonWrapper:{
        marginHorizontal:20,
        marginTop:30,
        marginBottom:20,
        backgroundColor:colors.primary,
        alignItems:'center',
        paddingVertical:15,
        borderRadius:10,
    },
    noTaskText:{
        fontFamily:'Raleway-Regular',
        fontSize:25,
        marginTop:40,
        marginBottom:20,
        paddingLeft:20,
        color:colors.textDark,
    },
  
    addTaskButton:{
        color:colors.white,
        fontFamily:'Raleway-Regular',

    },

    buttonText:{
        fontFamily:'Raleway-Bold',
        fontSize:25,
        color:colors.white,
    },


    // Adding Tasks
    addTasksWrapper:{
        marginHorizontal:20,
        marginTop:30,
        marginBottom:20,
        backgroundColor:colors.primary,
        alignItems:'center',
        paddingVertical:15,
        borderRadius:10,
    },
    textBox:{
        fontFamily:'Raleway-Bold',
        fontSize:25,
        color:colors.white,
    },
    addTaskTextSave:{
        fontFamily:'Raleway-Bold',
        fontSize:25,
        color:colors.white,
        paddingTop:20,
    },
    backButton:{
        fontFamily:'Raleway-Bold',
        fontSize:25,
        color:colors.white,
        paddingTop:20,
    },
    TaskNameText:{
        paddingTop:20,
        paddingBottom:20,
        borderRadius:10,
        

    },



    // headerWrapper:{
    //     flexDirection:'row',
    //     justifyContent:'space-between',
    //     paddingHorizontal:0,
    //     paddingTop:0,
    //     alignItems:'center',
    // },
    // profileImage:{
    //     width:116,
    //     height:167,
    //     borderRadius:3,
    // },

    // textBox:{
    //     margin: 5,
    //     backgroundColor: "#C0C0C0",
    //     borderColor: "#C0C0C0"
    // },
    // // TODAY TASK'S
    // taskItem:{
    //     margin: 5,
    //     flex: 1,
    //     padding: 20,
    //     backgroundColor:colors.backgroundLight,
    // },
    // tasksWrapper:{
    //     paddingTop: 80,
    //     paddingHorizontal: 20,
    // },
    // sectionTitle:{
    //     fontFamily:'Raleway-Bold',
    //     fontSize: 24,
       
    // },
    // items:{
    //     marginTop:30,
    // },
  
    // //Task's Styling
    // writeTaskWrapper:{
    //     position:'absolute',
    //     bottom: 60,
    //     width:'100%',
    //     flexDirection:'row',
    //     justifyContent:'space-around',
    //     alignItems:'center'
      
      
      
    //   },
      
    //   input:{
    //   paddingVertical:15,
    //   paddingHorizontal:15,
    //   backgroundColor:colors.primary,
    //   borderRadius:60,
    //   borderColor:'#C0C0C0',
    //   borderWidth:1,
    //   width:250,
    //   },
      
    //   addWrapper:{
    //     width:12,
    //     height:12,
    //     backgroundColor:colors.background,
    //     borderRadius:12,
    //     justifyContent:'space-around',
    //     alignItems:'center',
    //     borderColor:colors.secondary,
    //     borderWidth:1,  
      
      
    //   },
    //   addText:{},
 
      

    // main:{
    //     backgroundColor: colors.background,
    // },
    
  
    // infoText:{
    //     fontSize: 30
    // },

    //  // Mark Completed Styling
    //  markCompeteText:{
    //      fontFamily:'Raleyway-Bold',
    //      fontSize:12,
    //  },
    
    //  addText:{
    //      textAlign:'justify'
    //  },
    //  popularTopWrapper:{
    //     flexDirection:'row',
    //     alignItems:'center',
    // },


    // // DELETE!!!
    // deleteTaskWrapper:{
        
    // },
    // buttonContainer:{},
    // deleteText:{},

    // //ADD TASK
    // addTaskWrapper:{
    //     width:60,
    //     height:60,
    //     backgroundColor:'#FFF',
    //     borderRadius:60,
    //     justifyContent:'center',
    //     alignItems:'center',
    //     borderColor:'#C0C0C0',
    //     borderWidth:1, 
    // },
    // AddTaskText:{},

    // // USERNAME
    // userNameText:{
    //     fontSize:16,
    //     fontFamily:'Raleway-ExtraBold',
    //     flexDirection:'column',
    //     flex:1,
    //     justifyContent:'flex-start',
    //     alignSelf:'flex-end',
    //     position:'absolute',
    //     bottom:35,
        
       
 

    // },




    },
)
