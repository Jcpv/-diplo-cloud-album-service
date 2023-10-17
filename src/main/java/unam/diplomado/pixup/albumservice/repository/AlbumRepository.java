// ARCHIVO - 2 - 

package unam.diplomado.pixup.albumservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.albumservice.domain.Album;

public interface AlbumRepository 
	extends MongoRepository <Album, String> { 
}
