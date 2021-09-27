import { hidden } from 'jest-matcher-utils/node_modules/chalk';
import { abort } from 'process';
import React from 'react';
import {View, 
        Text, 
        TouchableOpacity, 
        ImageBackground, 
        StyleSheet,
        Dimensions,
        Image} from 'react-native';
import { required } from 'yargs';
import colors from '../assets/colors/colors';

const height = Dimensions.get("window").height;


const StartPage = (props) => {
    return (
        <View style={styles.container}>
            <TouchableOpacity onPress={props.enterApp}>
            <ImageBackground 
            source={require('../assets/images/bikeLights.jpg')} 
            style={styles.discoverImage}
            imageStyle={styles.discoverbackgroundImage}>
                 <Text style={styles.discoverquoteText}>
                 Use React Native they said, 
                 It's easy they said.
                     </Text>
                     <Text style={styles.continueTextButton}>Continue</Text>

            </ImageBackground>
        </TouchableOpacity>
        </View>
        

        
    )
}
const styles = StyleSheet.create({

    container:{
        flex:1,
        backgroundColor:colors.backgroundLight,
    },

    quoteWrapper:{
        position:'relative',
       
    },

    StartPageText:{
        justifyContent:'flex-end',

    },

    discoverImage:{
        height:height,
        justifyContent:'center',
        paddingHorizontal:20,
        paddingVertical:15,
    },

    discoverbackgroundImage:{
    },


    discoverquoteText:{
        color:colors.white,
        fontFamily:'Raleway-Bold',
        fontSize:55,
     
    },
    continueTextButton:{
        color:colors.white,
        fontFamily:'Raleway-Regular',
        fontSize:25,
        paddingTop:30,
        paddingBottom:20,
        },





            
})
export default StartPage;