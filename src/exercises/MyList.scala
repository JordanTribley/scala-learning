package exercises

/*
  Implement a singly linked list, holds integers
  head = first element of this list
  tail = remainder of the list
  isEmpty = Boolean (is this list empty)
  add(int) => new list with this element added
  toString => a string representation of the list (override)
 */

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(el: Int): MyList
  // override def toString: String
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(el: Int): MyList = new Cons(el, Empty)
  // override def toString: String = ""
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(el: Int): MyList = new Cons(el, this)
  // override def toString: String = s"${this.head} ${this.t.toString}"
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)

  // polymorphic call
  println(list.toString)
}

/*class Node(val value: Int, val next: Node)

class theList(node: Node) extends MyList {
  def head: Int = node.value
  def tail: Node = node.next
  def isEmpty: Boolean = node.value != null
  def add(el: Int): MyList = ???
}

class List extends MyList {
  val node3 = new Node(3, null)
  val node2 = new Node(2, node3)
  val node1 = new Node(1, node2)

  val l = new theList(node1)
} */


