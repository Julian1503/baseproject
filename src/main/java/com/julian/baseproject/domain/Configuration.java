package com.julian.baseproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor @Data @Table(name="configurations")
public class Configuration {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "configuration_id", nullable = false)
  private Long configurationId;
  @Column(name = "date_format", nullable = false)
  private int dateFormat;
  @Column(name = "time_format", nullable = false)
  private int timeFormat;
  @Column(name = "language", nullable = false)
  private int language;

  @OneToOne()
  @JoinColumn(name = "user_id", referencedColumnName = "user_id")
  private User user;
}
