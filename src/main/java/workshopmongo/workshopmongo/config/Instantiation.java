package workshopmongo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import workshopmongo.workshopmongo.domain.Post;
import workshopmongo.workshopmongo.domain.User;
import workshopmongo.workshopmongo.dto.AuthorDTO;
import workshopmongo.workshopmongo.repository.PostRepository;
import workshopmongo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post firstPost = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar algum dia", new AuthorDTO(maria));
        Post secondPost = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Feliz dia!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(firstPost, secondPost));
    }
    
}
