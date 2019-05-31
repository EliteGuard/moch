package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal energyCritical;
    private BigDecimal energySufficient;
    private BigDecimal energyGood;
    private BigDecimal energyFull;
    private BigDecimal maxVelocity;
    private BigDecimal maxReverseVelocity;
    private BigDecimal currentEnergy;
    private Boolean loaded;

    @ManyToOne
    private VehicleState state;

    private String processingState;
    private String position;
    private String orientation;

    @ManyToOne
    private TransportOrder currentOrder;

    @ManyToOne
    private TransportOrderCategory orderCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private Set<VehicleMiscellaneous> misc = new HashSet<>();

    @ManyToOne
    private Point currentPoint;

    @ManyToOne
    private Point nextPoint;

    @ManyToOne
    private Map map;

}
