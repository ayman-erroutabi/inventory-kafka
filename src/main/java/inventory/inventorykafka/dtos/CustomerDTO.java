package inventory.inventorykafka.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {

    private long id;

    private String customerName;

    private String email;

    private String address;

}
