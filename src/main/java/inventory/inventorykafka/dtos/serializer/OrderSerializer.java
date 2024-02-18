package inventory.inventorykafka.dtos.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import inventory.inventorykafka.constants.LoggerConstants;
import inventory.inventorykafka.dtos.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class OrderSerializer implements Serializer<OrderDTO> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, OrderDTO data) {
        try {
            if (data == null){
                log.error(LoggerConstants.NULL_RECEIVED_AT_SERIALIZING_STRING);
                throw new SerializationException(LoggerConstants.NULL_RECEIVED_AT_SERIALIZING_STRING);
            }
            log.info(LoggerConstants.SERIALIZING_STRING + data.toString());
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException(LoggerConstants.ERROR_SERIALIZING_MESSAGE_DTO_STRING);
        }
    }
}