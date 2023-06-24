package org.example.model;

public class Toy {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private int percent;
    private int count;
    public Toy(Integer id, String name, Integer percent, Integer count) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Toy: " +
                "ID=" + id +
                ", name=" + name +
                ", percent=" + percent +
                ", count=" + count + ";" +
                "\n";
    }
}