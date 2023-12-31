package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="banque_seq",sequenceName="banque_seq",allocationSize=1, initialValue = 1)
public class Banque   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public Banque(){
        super();
    }

    public Banque(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Banque(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="banque_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banque banque = (Banque) o;
        return id != null && id.equals(banque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

