package com.yapp.crew.domain.model;

import com.yapp.crew.domain.status.GroupStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter(value = AccessLevel.PRIVATE)
  @Column(nullable = false)
  private String title;

  @Setter(value = AccessLevel.PROTECTED)
  @JoinColumn(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @Setter(value = AccessLevel.PRIVATE)
  @JoinColumn(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;

  @Setter(value = AccessLevel.PRIVATE)
  @JoinColumn(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Address address;

  @Setter(value = AccessLevel.PRIVATE)
  @JoinColumn(nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Tag tag;

  @Enumerated(value = EnumType.ORDINAL)
  @Column(nullable = false)
  private GroupStatus status = GroupStatus.RECRUITING;

  @Column(name = "recruit_count", nullable = false)
  private Integer recruitCount = 0;

  @Setter(value = AccessLevel.PRIVATE)
  @Column(name = "starts_at", nullable = false)
  private LocalDateTime startsAt;

  // TODO: add, delete, increase, decrease, update function

  public static BoardBuilder getBuilder() {
    return new BoardBuilder();
  }

  public static class BoardBuilder {
    private String title;
    private User user;
    private Category category;
    private Address address;
    private Tag tag;
    private LocalDateTime startsAt;

    public BoardBuilder withTitle(String title) {
      this.title = title;
      return this;
    }

    public BoardBuilder withUser(User user) {
      this.user = user;
      return this;
    }

    public BoardBuilder withCategory(Category category) {
      this.category = category;
      return this;
    }

    public BoardBuilder withAddress(Address address) {
      this.address = address;
      return this;
    }

    public BoardBuilder withTag(Tag tag) {
      this.tag = tag;
      return this;
    }

    public BoardBuilder withStartsAt(LocalDateTime startsAt) {
      this.startsAt = startsAt;
      return this;
    }

    public Board build() {
      Board board = new Board();
      board.setTitle(title);
      board.setUser(user);
      board.setCategory(category);
      board.setAddress(address);
      board.setTag(tag);
      board.setStartsAt(startsAt);
      return board;
    }
  }
}
