package inventory.inventorykafka.dtos.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import inventory.inventorykafka.constants.LoggerConstants;
import inventory.inventorykafka.dtos.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
public class OrderDeserializer implements Deserializer<OrderDTO> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public OrderDTO deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                log.error(LoggerConstants.NULL_RECEIVED_AT_DESERIALIZING_STRING);
                throw new SerializationException(LoggerConstants.NULL_RECEIVED_AT_DESERIALIZING_STRING);
            }
            log.info(LoggerConstants.DESERIALIZING_STRING);
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), OrderDTO.class);
        } catch (Exception e) {
            throw new SerializationException(LoggerConstants.ERROR_DESERIALIZING_MESSAGE_DTO_STRING);
        }
    }
}