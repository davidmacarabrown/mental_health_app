import React, {useEffect, useState} from 'react';
import {View, Text , StyleSheet, Image, FlatList, ActivityIndicator, Pressable, TouchableOpacity, Button, TouchableOpacityBase,ScrollView,KeyboardAvoidingView,TextInput} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import colors from '../assets/colors/colors';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';
import TaskItem from './TaskItem';

export default function Home () {

    const testUserId = 1
    
    const [tasks, setTasks] = useState([]);
    const [tasksLoaded, setTasksLoaded] = useState(false);
    const [userData, setUserData] = useState({})
    const [userLoaded, setUserLoaded] = useState(false)

    const handleAddTask = () => {
        Keyboard.dismiss();
        setTaskItems([...tasks, tasksLoaded])
        setTask(null);
      }

    const TaskItem = ({item, onPress}) => (
        <View style={styles.taskItem}>

            {/* Today's Tasks  */}
      <View style={styles.tasksWrapper}>
        <Text style={styles.sectionTitle}>Today's Tasks</Text>

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
    
        //MARK COMPLETED
    const renderItem = ({item}) => {
        const taskId = item.id;
        return(
            <View style={styles.markCompletedWrapper}>
            <TaskItem 
                item={item}
                onPress={()=> markComplete(testUserId, taskId)}
                />
            </View>
        )
    }

    return(
        // HEADER
        <View style={styles.container}>
        
        <ScrollView>
        <SafeAreaView>
            <View style={styles.headerWrapper}>
                <Image 
                key={Date.now()}
                source={require('../assets/images/AvatarGirl1.jpeg')} 
                style={styles.profileImage}/>
               


            <Feather name="menu" size={24} color={colors.textDark}/>
            </View>
        </SafeAreaView>

        <KeyboardAvoidingView
      behavior = {Platform.OS === "ios" ? "padding" : "height"}
      style={styles.writeTaskWrapper}
      >
     <TextInput style={styles.input} placeholder={'Write a task'} value={tasksLoaded} onChangeText={text => setTask(text)}/>
        
        <TouchableOpacity onPress={() => handleAddTask()}>
          <View style={styles.addWrapper}>
            <Text style={styles.addText}>+</Text>

          </View>

        </TouchableOpacity>
      </KeyboardAvoidingView>

            {/* DELETED TASK BOX*/}

        <View style={styles.main}>
        {userLoaded === false || tasks.length === 0 ?  <Text>LOADING...</Text> : 

            <View style={styles.deleteTaskWrapper}>
                <TouchableOpacity style={styles.buttonContainer} onPress={()=> deleteTask(testUserId, 1)}>
                    <Text style={styles.deleteText}></Text>
                      <MaterialCommunityIcons
                        name="delete"
                         size={30}
                        color={colors.primary}
                    />

                </TouchableOpacity>

           
                    {/* MARK COMPLETED BOX */}
                <TouchableOpacity 
                style={styles.buttonContainer} 
                onPress={()=> markComplete(testUserId, 1)}>
                    <Text style={styles.markCompeteText}></Text>
                    <MaterialCommunityIcons
                        name="check"
                         size={30}
                        color={colors.primary}
                    />
                    <View style={styles.addWrapper}>

          </View>
                </TouchableOpacity>

                <Text>-----------------------</Text>
               

                <TouchableOpacity onPress={()=> addTask(testUserId, payload)}>
                    <Text>Add Task</Text>
                    <View style={styles.addTaskWrapper}>
                    <Text style={styles.AddTaskText}>+</Text>
                    </View>
                </TouchableOpacity>

           
                <Text>-----------------------</Text>
                <Text>{tasks.length.toString()}</Text>
                <Text>-----------------------</Text>
               
                <FlatList 
                    data={tasks}
                    renderItem={renderItem}
                    keyExtractor={(item) => item.id}
                />
            </View>
        
        }   
                <Text>-----------------------</Text>
           

        {userLoaded ? <View>
                            <Text style={styles.userNameText}>{userData.username}</Text>
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
        </ScrollView>     
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
