package foro.hub.api.domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import foro.hub.api.domain.usuarios.Usuario;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long usuario_id;
    private String curso;


    public Topico(@Valid DatosRegistroTopico datos, Usuario usuario) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.curso = datos.curso();
        this.status = Status.DISPONIBLE;
        this.fecha_creacion = LocalDateTime.now();
        this.usuario_id = usuario.getId();
    }

    public void actualizarInfoTopico(DatosActualizarTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.status() != null) {
            try {
                this.status = Status.valueOf(datos.status().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("El estado proporcionado no es válido: " + datos.status());
            }
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }

}
