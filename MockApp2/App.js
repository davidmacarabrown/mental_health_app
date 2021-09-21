import * as React from 'react';
import {Text} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';


import Home from './components/Home';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
    <Stack.Navigator>
      {/* Options headerShown false will hide the header on top of the app */}
      <Stack.Screen name="Home" component={Home} options = {{
        headerShown:false,
      }} />
    </Stack.Navigator>
  </NavigationContainer>
  );
}