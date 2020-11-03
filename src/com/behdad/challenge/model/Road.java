package com.behdad.challenge.model;

import java.util.List;
import java.util.Objects;

public class Road {
    private Integer id;
    private String name;
    private Integer from;
    private Integer to;
    private List<Integer> through;
    private Integer speedLimit;
    private Integer length;
    private Boolean bidirectional;

    private Road() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public List<Integer> getThrough() {
        return through;
    }

    public void setThrough(List<Integer> through) {
        this.through = through;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getBidirectional() {
        return bidirectional;
    }

    public void setBidirectional(Boolean bidirectional) {
        this.bidirectional = bidirectional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Objects.equals(id, road.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Road{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", through=" + through +
                ", speedLimit=" + speedLimit +
                ", length=" + length +
                ", bidirectional=" + bidirectional +
                '}';
    }

    public static class RoadBuilder{
        private Integer id;
        private String name;
        private Integer from;
        private Integer to;
        private List<Integer> through;
        private Integer speedLimit;
        private Integer length;
        private Boolean bidirectional;

        public RoadBuilder(Integer id) {
            this.id = id;
        }

        public Road build(){
            Road road = new Road();
            road.setBidirectional(this.bidirectional);
            road.setFrom(this.from);
            road.setId(this.id);
            road.setLength(this.length);
            road.setName(this.name);
            road.setSpeedLimit(this.speedLimit);
            road.setThrough(this.through);
            road.setTo(this.to);
            return road;
        }

        public RoadBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoadBuilder from(Integer from) {
            this.from = from;
            return this;
        }

        public RoadBuilder to(Integer to) {
            this.to = to;
            return this;
        }

        public RoadBuilder through(List<Integer> through) {
            this.through = through;
            return this;
        }

        public RoadBuilder speedLimit(Integer speedLimit) {
            this.speedLimit = speedLimit;
            return this;
        }

        public RoadBuilder length(Integer length) {
            this.length = length;
            return this;
        }

        public RoadBuilder bidirectional(Boolean bidirectional) {
            this.bidirectional = bidirectional;
            return this;
        }
    }
}
