import java.util.Date;
import java.util.List;


public class Test {
    private Date m_time;
    private String m_name;
    private List<Integer> m_numbers;
    private List<String> m_strings;

    private static final String stringsNullError = "string not set";
    private static final String numbersNullError = "numbers not set";
    private static final String dateNullError = "date not set";

    public Test(Date time, String name, List<Integer> numbers, List<String> strings) {
        this.m_time = time;
        this.m_name = name;
        this.m_numbers = numbers;
        this.m_strings = strings;
    }

    public List<String> getM_strings() {
        return m_strings;
    }


    public void setM_strings(List<String> strings) {
        this.m_strings = strings;
    }

    public List<Integer> getM_numbers() {
        return m_numbers;
    }


    public void setM_numbers(List<Integer> numbers) {
        this.m_numbers = numbers;

    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public Date getM_time() {
        return m_time;
    }

    public void setM_time(Date m_time) {
        this.m_time = (Date) m_time;
    }

    public boolean equals(Object obj) {

        try {
            if (!(obj instanceof Test))
                return false;

            if(!isNameEqual(((Test) obj).getM_name()))
                return false;

            if(!isTimeEqual(((Test) obj).getM_time()))
                return false;

            if(!ifNumberListEqual(((Test) obj).getM_numbers()))
                return false;

            if (!ifStringListEqual(((Test) obj).getM_strings()))
                return false;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }

    private boolean isNameEqual(String name){

        if ((name != null && this.m_name == null) ||
                ((name == null && this.m_name != null)))
            return false;
        else if (name != null && m_name!=null &&
                !m_name.equals(name))
            return false;

        return true;
    }

    private boolean isTimeEqual(Date time){

        if ((time != null && this.m_time == null) ||
                ((time==null && this.m_time != null)))
            return false;
        else if (m_time != null && time != null
                && !m_time.equals(time))
            return false;

        return true;
    }

    private boolean ifNumberListEqual(List<Integer> numList) {
        int index = 0;

        if ((numList != null && this.m_numbers == null) ||
                (numList == null && this.m_numbers != null))
            return false;

        if(numList==null && this.m_numbers==null)
            return true;

        if(numList.size()!=m_numbers.size())
            return false;

        for (Integer number : m_numbers) {
            if (!number.equals(numList.get(index)))
                return false;
            index++;
        }

        return true;
    }

    private boolean ifStringListEqual(List<String> stringList) {
        int index = 0;


        if ((stringList != null && this.m_strings == null) ||
                (stringList == null && this.m_strings != null))
            return false;

        if(stringList==null && this.m_strings==null)
            return true;

        if(stringList.size()!=this.m_strings.size())
            return false;

        for (String elem : m_strings) {
            if (!elem.equals(stringList.get(index)))
                return false;
            index++;
        }

        return true;
    }

    public String toString() {
        StringBuilder out = new StringBuilder()
                .append(m_time != null ? " " +m_time : "")
                .append(m_name != null ? " " +m_name : "")
                .append(m_numbers != null ? " " + m_numbers.toString() : "")
                .append(m_strings != null ? " " + m_strings.toString() : "");

        return out.toString();
    }

    public void removeString(String str) throws ElementNotExists, FieldNotSet {

        if (this.m_strings == null)
            throw new FieldNotSet(this.stringsNullError);

        if (str == null || !this.m_strings.contains(str))
            throw new ElementNotExists();


        m_strings.remove(str);
    }

    public boolean containsNumber(int number) throws FieldNotSet, ElementNotExists {

        if (this.m_numbers == null)
            throw new FieldNotSet(this.numbersNullError);

        if (this.m_numbers == null)
            throw new ElementNotExists();

        return m_numbers.contains(number);
    }

    public boolean isHistoric() throws FieldNotSet {

        if (m_time == null)
            throw new FieldNotSet(this.dateNullError);

        return m_time.before(new Date());
    }

}

class ElementNotExists extends Exception {
    private static final String message = "Element does not exist";

    public ElementNotExists() {
        super(message);
    }
}

class FieldNotSet extends Exception {
    FieldNotSet(String errorMessage) {
        super(errorMessage);
    }
}


