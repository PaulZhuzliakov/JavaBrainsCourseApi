package io.javabrains.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Description"),
            new Topic("Java", "Java Core", "Java Core Description"),
            new Topic("Javascript", "JavaScript", "Javascript Description")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }


    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void putTopic(Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(topic.getId())) {
                topics.set(i, topic);
                return;
            }
        }
        addTopic(topic);
    }

    public void deleteTopic(String id) {
//        for (int i = 0; i < topics.size(); i++) {
//            if (topics.get(i).getId().equals(id)) {
//                topics.remove(i);
//                return;
//            }
//        }
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
