package unam.diplomado.pixup.albumservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.albumservice.domain.Album;
import unam.diplomado.pixup.albumservice.repository.AlbumRepository;

@Service 
public class AlbumServiceImpl implements AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public Album actualizarAlbum(String id, Album album)  {
		Optional<Album> albumExistente = albumRepository.findById(id);
		
		if (albumExistente.isPresent()) {
			Album albumActualizar = albumExistente.get();
			albumActualizar.setNombre(album.getNombre());
			albumRepository.save(albumActualizar);
			return albumActualizar;
		}
		
		return null;
	}

}
