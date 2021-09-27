import React from 'react';
import {StyleSheet, View, Text, TouchableOpacity} from 'react-native';
import Feather from 'react-native-vector-icons/Feather';
import colors from '../assets/colors/colors';

const TaskItem = (props) => {

    console.log("TASK ITEM PROPS:", props,)
    return(
            <View>
                
                <View style={styles.taskItem}>
                    <View>
                    <Text style={styles.taskName}>{props.item.name}</Text>
                        <Text style={styles.descriptionItem} >{props.item.description}</Text>
                    </View>
                    
                        

                        <View style={styles.tickItem}>
                        {!props.item.status ?
                        <TouchableOpacity onPress={props.markComplete} style={styles.taskButton}> 
                            <Feather
                                name="check"
                                size={30 }
                                color={colors.primary}
                            />
                        </TouchableOpacity >:
                        <Feather
                                name="check"
                                size={30 }
                                color={"#15bb00"}
                            />
                            }
                        
                        </View>
                    
                    <TouchableOpacity onPress={props.deleteTask} style={styles.taskButton}>
                            <Feather name="x-circle"
                                    size={30 }
                                    color={"#b53833"}/>
                    </TouchableOpacity>
                </View>
            </View>
    )
}

const styles = StyleSheet.create({

    taskItem:{
        margin: 5,
        flex: 1,
        padding: 20,
        backgroundColor:colors.primary,
        borderRadius:10,
       

    },

    taskName:{
        color:colors.white,
        fontFamily:'Raleway-Bold',
        fontSize:25,

    },

    descriptionItem:{
        color:colors.white,
        fontFamily:'Raleway-Bold',
        fontSize:25,
    },

    tickItem:{
        position:'absolute',
        right:0,
        margin:10,
        bottom:0,

    },

    
    }
)

export default TaskItem;
