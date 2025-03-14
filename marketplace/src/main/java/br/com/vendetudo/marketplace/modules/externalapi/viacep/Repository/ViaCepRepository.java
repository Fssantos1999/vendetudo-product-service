package br.com.vendetudo.marketplace.modules.externalapi.viacep.Repository;
import br.com.vendetudo.marketplace.modules.externalapi.viacep.ViaCepResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaCepRepository extends JpaRepository<ViaCepResponse,Long> {
}
