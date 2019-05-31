package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class TransportOrderEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime time;

    @ManyToOne
    private TransportOrder order;

}
