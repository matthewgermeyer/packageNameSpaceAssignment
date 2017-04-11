import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Foo {
    private int id;
    private String name;

    //Constructor
    public Foo() {
    }

    //Get 'n Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //reflectionToString -> ToStringBuilder
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    //Hashcode()
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Foo == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Foo otherObject = (Foo) obj;

        return new EqualsBuilder()
                .append(this.id, otherObject.id)
                .append(this.name, otherObject.name)
                .isEquals();
    }
}
