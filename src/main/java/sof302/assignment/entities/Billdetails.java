package sof302.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billdetails {
    @EmbeddedId
    private Pk pk;
    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pk implements Serializable {
        private Integer pid;
        private Integer bid;
    }
    private Integer quantity;
}
