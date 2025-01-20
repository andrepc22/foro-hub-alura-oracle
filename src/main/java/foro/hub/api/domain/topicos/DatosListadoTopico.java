package foro.hub.api.domain.topicos;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String usuarioNombre,
        String curso
) {
    public DatosListadoTopico(Topico topico, String nombreUsuario) {

        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getStatus(),
                nombreUsuario,
                topico.getCurso()
        );
    }
}
