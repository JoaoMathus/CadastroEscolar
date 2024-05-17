package classes_base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter @Setter @NoArgsConstructor
public class Aluno extends Pessoa {
    final String matricula;
    Map<String, Float> notasDeProva = new HashMap<>();

    private String serie;
    private String numeroTurma;
    private String tipoSanguineo;
    private List<String> telefones = new ArrayList<String>();
    private String cpfDoResponsavel;

    public Aluno(Long id, String nome, String dataNascimento, String matricula, String serie, String numeroTurma, String tipoSanguineo, List<String> telefones, String cpfDoResponsavel) {
        super(id, nome, dataNascimento);
        this.matricula = matricula;
        this.serie = serie;
        this.numeroTurma = numeroTurma;
        this.tipoSanguineo = tipoSanguineo;
        this.telefones = telefones;
        this.cpfDoResponsavel = cpfDoResponsavel;
        notasDeProva.put("AV1", 0.0f);
        notasDeProva.put("AV2", 0.0f);
    }

    public float calcularMedia() {
        // A maravilha que é programação funcional
        return getNotas()
                .values()
                .stream()
                .reduce(0.0F, Float::sum) / getNotas().size();
    }
}
