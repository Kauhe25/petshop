package br.com.tt.petshop.mapper;

import br.com.tt.petshop.model.Animal;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-19T22:27:47-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public String fromAnimal(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        String string = new String();

        return string;
    }
}
