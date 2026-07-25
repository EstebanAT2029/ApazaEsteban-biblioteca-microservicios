package pe.codigo.libros.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.codigo.libros.entity.Ejemplar;
import pe.codigo.libros.entity.Socio;
import pe.codigo.libros.repository.EjemplarRepository;
import pe.codigo.libros.repository.SocioRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EjemplarRepository ejemplarRepository;
    private final SocioRepository socioRepository;

    @Override
    public void run(String... args) {

        if (ejemplarRepository.count() == 0) {

            ejemplarRepository.save(Ejemplar.builder()
                    .codigoEjemplar("BIB-0001")
                    .titulo("Clean Code")
                    .autor("Robert C. Martin")
                    .isbn("9780132350884")
                    .anioPublicacion(2008)
                    .disponible(true)
                    .build());

            ejemplarRepository.save(Ejemplar.builder()
                    .codigoEjemplar("BIB-0002")
                    .titulo("Effective Java")
                    .autor("Joshua Bloch")
                    .isbn("9780134685991")
                    .anioPublicacion(2018)
                    .disponible(true)
                    .build());

            ejemplarRepository.save(Ejemplar.builder()
                    .codigoEjemplar("BIB-0003")
                    .titulo("Spring in Action")
                    .autor("Craig Walls")
                    .isbn("9781617297571")
                    .anioPublicacion(2022)
                    .disponible(true)
                    .build());

        }

        if (socioRepository.count() == 0) {

            socioRepository.save(Socio.builder()
                    .codigoSocio("SOC001")
                    .nombre("Juan Perez")
                    .email("juan@gmail.com")
                    .telefono("999111222")
                    .activo(true)
                    .build());

            socioRepository.save(Socio.builder()
                    .codigoSocio("SOC002")
                    .nombre("Maria Lopez")
                    .email("maria@gmail.com")
                    .telefono("999333444")
                    .activo(false)
                    .build());

        }

    }

}