package oh.mycode.ohmycode.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class RenderPage <T>{
    private String url;
    private Page<T> page;
    private int totalPage;

    private int numElementsPerPage;

    private int pagActual;
    private List<PageElements> paginas;

    public RenderPage(String ur, Page <T> page){
        this.url=url;
        this.page=page;
        this.paginas = new ArrayList<PageElements>();

        totalPage = page.getTotalPages();
        numElementsPerPage = page.getSize();
        pagActual = page.getNumber()+1;
        int desde, hasta;
        desde =1;
        hasta = totalPage;

        for(int i = 0; i<hasta ; i++){
            paginas.add(new PageElements(desde+i, pagActual==desde+i));
        }
    }


}
