package utils;

/**
 * Created by ning on 1/22/16.
 */
public class EnumTest {

    public enum  Week{
        MONDAY(1),
        TUESDAY(2);

        private Integer value=null;

        Week(Integer value){
            this.value =value;
        }

    public Integer getValue(){
        return this.value;
    }

}
}
