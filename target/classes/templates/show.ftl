<#import "master.ftl" as layout />
<@layout.master title="Uutislukija">
    <article>
        <h1>${title}</h1>
        <#if uutinen??>
            <p>
                ${uutinen.otsikko}</br>
                <a href="${uutinen.url}">Lue uutinen täältä</a>
            </p>
        <#else>
            <p>Uutista ei löydetty.</p>
        </#if> 
        <p>
            <a href="./">Takaisin</a>
        </p>
    </article>
</@layout.master>