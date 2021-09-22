import {View, Text, FlatList} from 'react-native';
import TaskItem from './TaskItem';

export default function TaskList ({userId, tasks, onPressfunction}){

    const renderItem = ({item}) => {
        const taskId = item.id;
        return(
            <View>
            <TaskItem 
                item={item}
                onPress={()=> onPressFunction(userId, taskId)}
                />
            </View>
        )
    }

    return(
                <FlatList 
                    data={tasks}
                    renderItem={renderItem}
                    keyExtractor={(item) => item.id}
                />
    )
}