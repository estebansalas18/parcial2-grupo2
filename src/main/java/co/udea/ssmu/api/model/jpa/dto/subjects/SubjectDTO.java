package co.udea.ssmu.api.model.jpa.dto.subjects;

public class SubjectDTO {
    private Integer id;
    private String name;

    public SubjectDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}