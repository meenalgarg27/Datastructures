package com.meenal.datastructures;

public class Testing {

	public static class TextInput {
		private String c;

		public void add(char c) {
			if(this.c != null) {
				this.c = this.c + c;
			} else {
				this.c = Character.toString(c);
			}
		}

		public String getValue() {
			return this.c;
		}
	}

	public static class NumericInput extends TextInput {
		private String c;
		public void add(char c) {
			if(Character.isDigit(c)) {
				if(this.c != null) {
					this.c = this.c + c;
				} else {
					this.c = Character.toString(c);
				}
			}
		}
		public String getValue() {
			return this.c;
		}
	}

	public static void main(String[] args) {
		 TextInput input = new NumericInput();
		 input.add('1');
		input.add('a');
		 input.add('0');
		 System.out.println(input.getValue());
	}
}