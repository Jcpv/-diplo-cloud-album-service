// ARCHIVO - 4 -
package unam.diplomado.pixup.albumservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.pixup.albumservice.domain.Album;
import unam.diplomado.pixup.albumservice.repository.AlbumRepository;
import unam.diplomado.pixup.albumservice.service.AlbumService;

@RestController
@RequestMapping (path="api/albums", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="album", description ="API del Recurso - Album - ")
public class AlbumController {
	
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private AlbumService albumService;
	
	
	@Operation(summary="Obtener todos los albums")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", 
					description="Ok - al obtener todos los albums")
	})
	@GetMapping
	public List<Album> obtenerAlbums() {
		return albumRepository.findAll();
	}
	
	
	
	
	@Operation(summary="Crear Album")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", 
					description="Album Creado Correctamente", 
					content = {
							@Content (mediaType ="application/json",
							schema = @Schema(implementation=Album.class)) })
	})
	@PostMapping (consumes="application/json")
	@ResponseStatus (HttpStatus.CREATED)
	public Album crearAlbum(@RequestBody Album album){
		return albumRepository.save(album);
	}
	
	
	
	
	@Operation(summary="Obtener Album por un ID determinado")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", 
					description="Ok - al buscar album por ID")
	})
	@GetMapping("{id}")
	public ResponseEntity<Album> obtenerAlbumPorId(@PathVariable ("id") String id) {
		Optional<Album>  album = albumRepository.findById(id);
		if (album.isPresent()) {
			// return estado.get();
			return new ResponseEntity<>(album.get(), HttpStatus.OK);
		}
		//return null;
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	
	
	@Operation(summary="Actualizar NOMBRE de Album")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", 
					description="Album ACTUALIZADO Correctamente", 
					content = {
							@Content (mediaType ="application/json",
							schema = @Schema(implementation=Album.class)) })
	})
	@PutMapping(path="{id}", consumes ="application/json") 
	public ResponseEntity<Album> actualizarAlbum (@PathVariable("id") String id, @RequestBody Album album)
	{
		
		try {
			
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
		
		Album albumActualizado = albumService.actualizarAlbum(id, album);
		if (albumActualizado != null) {
			return new ResponseEntity<>(albumActualizado, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	} 
	
	
	
	
	@Operation(summary="Eliminar a un determinado Album por ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204", 
					description="No hay datos de respuesta, pero se elimina al album")
	})
	@DeleteMapping ("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarAlbum(@PathVariable("id") String id) {
		albumRepository.deleteById(id);
	}
}
