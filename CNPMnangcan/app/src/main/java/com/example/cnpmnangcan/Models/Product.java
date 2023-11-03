package com.example.cnpmnangcan.Models;

import org.bson.types.ObjectId;


    public class Product {
        private ObjectId id;
        private String name;
        private String image;
        private String type;
        private Number price;
        private Number CountInStock;
        private Number rating;
        private String Description;
        private Number Discount;
        private Number Selled;

        public Product(ObjectId id, String name, String image, String type, Number price, Number countInStock, Number rating, String description, Number discount, Number selled) {
            this.id = id;
            this.name = name;
            this.image = image;
            this.type = type;
            this.price = price;
            CountInStock = countInStock;
            this.rating = rating;
            Description = description;
            Discount = discount;
            Selled = selled;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Number getPrice() {
            return price;
        }

        public void setPrice(Number price) {
            this.price = price;
        }

        public Number getCountInStock() {
            return CountInStock;
        }

        public void setCountInStock(Number countInStock) {
            CountInStock = countInStock;
        }

        public Number getRating() {
            return rating;
        }

        public void setRating(Number rating) {
            this.rating = rating;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public Number getDiscount() {
            return Discount;
        }

        public void setDiscount(Number discount) {
            Discount = discount;
        }

        public Number getSelled() {
            return Selled;
        }

        public void setSelled(Number selled) {
            Selled = selled;
        }
    }

