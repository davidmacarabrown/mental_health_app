import React, {useEffect, useState} from 'react';
import {View, Text , StyleSheet, Image, FlatList, ActivityIndicator} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import Feather from 'react-native-vector-icons/Feather';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import colors from '../assets/colors/colors';
import categoriesData from '../assets/data/categoriesData';
import popularData from '../assets/data/popularData';

export default function Home () {

    const [isLoading, setLoading] = useState(true);
    const [tasksLoading, setTaskLoading] = useState(true);
    const [data, setData] = useState({});

    const loadData = function(){
        fetch("http://10.0.2.2:8080/users/1")
        .then((response) => response.json())
        .then((json) => setData(json))
        .catch(() => alert("Service Unavailable"))

        .finally(setLoading(false))

    }



    useEffect(() => {
        loadData()
    }, []);

    const userName = data.username
    const userXp = data.currentXp
    // const task1 = tasks[0].description
    

    return(
        <SafeAreaView>
        {isLoading && tasksLoading ? <Text>LOADING</Text> : 
        <View>
            <Text>{userName}</Text>
            <Text>{userXp}</Text>
            {/* <Text>{task1}</Text> */}
        </View>
        }
        
        </SafeAreaView>
    );
    
};

