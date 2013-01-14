package br.com.sorcesphere.converter;

public interface Converter<F,T>
{
	public T convertTo(F objeto);
	public F convertFrom(T objeto);
}
