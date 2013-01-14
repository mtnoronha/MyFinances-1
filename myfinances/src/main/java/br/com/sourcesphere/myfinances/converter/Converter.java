package br.com.sourcesphere.myfinances.converter;

public interface Converter<F,T>
{
	public T convertTo(F objeto);
	public F convertFrom(T objeto);
}
