package az.edu.orient.notification.consumer;

import az.edu.orient.notification.model.UserDto;
import az.edu.orient.notification.service.MailService;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMqConsuemr {

    private final MailService mailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.user}")
    public void listerUserQueue(UserDto userDto) {
        mailService.sendEmail(userDto.getEmail(), "Welcome", "Welcome to " + userDto.getFirstName() + " " + userDto.getLastName());
    }
}
