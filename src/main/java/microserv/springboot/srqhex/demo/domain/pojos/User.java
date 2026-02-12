package microserv.springboot.srqhex.demo.domain.pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class User {

    private Long id;
    private String name;
    private String email;

}
